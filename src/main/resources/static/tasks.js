const taskList = document.getElementById('taskList');
const taskForm = document.getElementById('taskForm');
const taskInput = document.getElementById('taskInput');

const API_URL = "http://localhost:8081/tasks";

// Load all tasks from backend
async function loadTasks() {
  const response = await fetch(API_URL);
  const tasks = await response.json();

  taskList.innerHTML = ''; // Clear list before rendering

  tasks.forEach(task => {
    const li = document.createElement('li');
    li.className = `task-card ${task.completed ? 'completed' : ''}`;

    li.innerHTML = `
      <span>${task.title} - ${task.completed ? "Completed" : "Pending"}</span>
      <div class="actions">
        <button class="toggle-btn" onclick="toggleTask(${task.id})">Toggle</button>
        <button class="delete-btn" onclick="deleteTask(${task.id})">Delete</button>
      </div>
    `;

    taskList.appendChild(li);
  });
}

// Add new task
taskForm.addEventListener('submit', async (e) => {
  e.preventDefault();
  const title = taskInput.value.trim();
  if (title === '') return;

  await fetch(API_URL, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ title, completed: false })
  });

  taskInput.value = '';
  loadTasks(); // Refresh task list
});

// Toggle task completion status
async function toggleTask(id) {
  await fetch(`${API_URL}/toggle/${id}`, { method: 'GET' });
  loadTasks();
}

// Delete a task
async function deleteTask(id) {
  await fetch(`${API_URL}/delete/${id}`, { method: 'DELETE' });
  loadTasks();
}

// Initial load
loadTasks();

function renderTasks(tasks) {
  const list = document.getElementById('task-list');
  list.innerHTML = '';

  tasks.forEach(task => {
    const li = document.createElement('li');
    li.className = 'task-item';

    // Container for task text
    const taskText = document.createElement('span');
    taskText.textContent = `${task.title} - ${task.completed ? 'Completed' : 'Pending'}`;
    taskText.style.flex = '1';

    // Toggle button
    const toggleBtn = document.createElement('button');
    toggleBtn.textContent = 'Toggle';
    toggleBtn.className = 'toggle-btn';
    toggleBtn.onclick = function () {
      fetch(`http://localhost:8080/tasks/${task.id}/toggle`, {
        method: 'PATCH'
      }).then(() => fetchTasks());
    };

    li.appendChild(taskText);
    li.appendChild(toggleBtn);
    list.appendChild(li);
  });
}

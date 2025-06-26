fetch('http://localhost:8080/tasks')  // GET request to fetch all tasks
  .then(response => response.json())
  .then(data => {
    const list = document.getElementById('task-list');
    list.innerHTML = "";
    data.forEach(task => {
      const li = document.createElement('li');
      li.textContent = `${task.title} - ${task.completed ? 'Completed' : 'Pending'}`;
      list.appendChild(li);
    });
  });

// Handle task form submission
document.getElementById("task-form").addEventListener("submit", function (e) {
  e.preventDefault();

  const task = {
    title: document.getElementById("name").value,
    completed: document.getElementById("status").value === "Completed"
  };

  fetch('http://localhost:8080/tasks', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(task)
  })
    .then(response => response.json())
    .then(data => {
      const list = document.getElementById('task-list');
      const li = document.createElement('li');
      li.textContent = `${data.title} - ${data.completed ? 'Completed' : 'Pending'}`;
      list.appendChild(li);
      document.getElementById("response").textContent = "Task added!";
    })
    .catch(error => {
      document.getElementById("response").textContent = "Error: " + error;
    });

  document.getElementById("task-form").reset();
});

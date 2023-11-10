function updateTaskList() {
    var taskList = document.getElementById('taskList');
    taskList.innerHTML = ''; // Clear the existing list

    // Fetch tasks from the server (in this case, from Java via AJAX)
    fetchTasks().then(function (tasks) {
        tasks.forEach(function (task, index) {
            var newTask = document.createElement('li');
            newTask.innerHTML = `
                <span>${task}</span>
                <button class="delete-btn" onclick="removeTask(${index})">Delete</button>
            `;
            taskList.appendChild(newTask);
        });
    });
}

function fetchTasks() {
    // In a real-world scenario, this should be replaced with AJAX/fetch to get tasks from the server.
    // For simplicity, we'll use a hardcoded array here.
    return Promise.resolve(['Task 1', 'Task 2', 'Task 3']); // Replace this with actual tasks from the server
}

function addTask() {
    var taskInput = document.getElementById('taskInput');

    if (taskInput.value.trim() !== '') {
        // In a real-world scenario, this should be replaced with AJAX/fetch to add tasks to the server.
        // For simplicity, we'll just update the UI here.
        updateTaskList();
        taskInput.value = '';
    }
}

function removeTask(index) {
    // In a real-world scenario, this should be replaced with AJAX/fetch to remove tasks from the server.
    // For simplicity, we'll just update the UI here.
    updateTaskList();
}

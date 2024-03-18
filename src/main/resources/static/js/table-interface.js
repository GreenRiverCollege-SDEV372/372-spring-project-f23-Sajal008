// Wait until the page finishes loading
window.onload = async function() {

    // Fetch music data
    const musicData = await fetchMusicData();
    displayMusicData(musicData);

    //submission for adding new data

    const addMusicForm = document.getElementById("addMusicForm");
    addMusicForm.addEventListener("submit", async function(event)
    {
        event.preventDefault();
        const title = document.getElementById("title").value;
        const genre = document.getElementById("genre").value;

        if (title && genre) {
            const newMusic = await addMusic(title, genre);
            if (newMusic) {
                displayMusic(newMusic);
                addMusicForm.reset();
            } else {
                alert("Failed to add new music. Please try again.");
            }
        } else {
            alert("Please enter both title and genre.");
        }
    });

    // For edit and delete
    document.getElementById("musicTableBody").addEventListener("click", async function(event) {
        const target = event.target;
        if (target.classList.contains("edit")) {
            const row = target.closest("tr");
            editMusic(row);
        } else if (target.classList.contains("delete")) {
            const row = target.closest("tr");
            const id = row.dataset.id;
            const confirmation = confirm("Are you sure you want to delete this record?");
            if (confirmation) {
                const success = await deleteMusic(id);
                if (success) {
                    row.remove();
                } else {
                    alert("Failed to delete music. Please try again.");
                }
            }
        }
    });
};

// Function to display music data in the table
function displayMusicData(musicData) {
    const musicTableBody = document.getElementById("musicTableBody");
    musicTableBody.innerHTML = "";
    musicData.forEach(music => displayMusic(music));
}

// Function to display a single music record in a table row
function displayMusic(music) {
    const row = document.createElement("tr");
    row.innerHTML = `
        <td>${music.id}</td>
        <td>${music.title}</td>
        <td>${music.genre}</td>
        <td><a href="#" class="edit">Edit</a></td>
        <td><a href="#" class="delete">Delete</a></td>
    `;
    row.dataset.id = music.id; // Store music ID in a data attribute
    document.getElementById("musicTableBody").appendChild(row);
}

// Function to populate form fields with existing music data for editing
function editMusic(row) {
    const id = row.dataset.id;
    const title = row.cells[1].textContent;
    const genre = row.cells[2].textContent;
    const titleInput = document.getElementById("title");
    const genreInput = document.getElementById("genre");
    titleInput.value = title;
    genreInput.value = genre;

    // Handle form submission for updating existing record
    const addMusicForm = document.getElementById("addMusicForm");
    addMusicForm.onsubmit = async function(event) {
        event.preventDefault();
        const newTitle = titleInput.value;
        const newGenre = genreInput.value;
        if (newTitle && newGenre) {
            const success = await updateMusic(id, newTitle, newGenre);
            if (success) {
                row.cells[1].textContent = newTitle;
                row.cells[2].textContent = newGenre;
                addMusicForm.reset();
            } else {
                alert("Failed to update music. Please try again.");
            }
        } else {
            alert("Please enter both title and genre.");
        }
    };
}

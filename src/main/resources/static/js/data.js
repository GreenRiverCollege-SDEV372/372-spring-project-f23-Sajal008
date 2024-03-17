// When the page loads
window.onload = async function() {
    // Fetch music data
    const uri = "http://localhost:8080/api/v1/music/all";
    const config = { method: 'get' };
    const response = await fetch(uri, config);
    const data = await response.json();
    showMusic(data);

    // Handle form submission
    const button = document.querySelector("button");
    button.onclick = addMusic;
};

// Add new music
async function addMusic(event) {
    event.preventDefault(); // Prevent form submission
    const newMusic = {
        title: document.querySelector("#title").value,
        genre: document.querySelector("#genre").value
    };
    const uri = "http://localhost:8080/api/v1/music";
    const config = {
        method: "post",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newMusic)
    };
    const response = await fetch(uri, config);
    const music = await response.json();
    const section = document.querySelector("#music");
    addMusicSection(section, music);
}

// Display music
function showMusic(music) {
    const section = document.querySelector("#music");
    for (const item of music) {
        addMusicSection(section, item);
    }
}

// Add music section to HTML
function addMusicSection(section, music) {
    const musicDiv = document.createElement("div");
    musicDiv.classList.add("music");

    const titleHeader = document.createElement("h2");
    titleHeader.textContent = music.title;

    const idParagraph = document.createElement("p");
    idParagraph.textContent = `ID #${music.id}`;

    const genreParagraph = document.createElement("p");
    genreParagraph.textContent = `Genre: ${music.genre}`;

    musicDiv.appendChild(titleHeader);
    musicDiv.appendChild(idParagraph);
    musicDiv.appendChild(genreParagraph);

    section.appendChild(musicDiv);
}

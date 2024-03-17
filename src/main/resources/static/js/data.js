//begin the pasge loade

window.onload = async function() {
    //fetch the data
    const uri = "http://localhost:8080/api/v1/music/all";
    const config = {
        method: 'get'
    }

    const response = await fetch(uri, config);
    const data = await response.json();
    showMusics(data);

    const button = document.querySelector("button");
    button.onclick = addMusic;



    function showMusics(music)
    {
        const section = document.querySelector("#music");
        console.log(section);


        for (let i = 0; i < music.length; i++)
        {
            const music = music[i];
            addMusicSection(section, music);
        }
    }

    function addMusicSection(section, music)
    {
        section.innerHTML += `<div class="music">
            <h2>${music.title}</h2>
            <p>ID #${music.id}</p>
            <p>Artist: ${music.artist}</p>
        </div>`;
    }}

// to show music on the page

async function addMusic(event)
{
    //stop the form from submitting
    event.preventDefault();

    const newMusic = {
        title: document.querySelector("#title").value,
        genre: document.querySelector("#genre").value
    }

    const uri = "http://localhost:8080/music/all";
    const config = {
        method: "post",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(newMusic)
    }

    const response = await fetch(uri, config);
    const music = await response.json();

    const section = document.querySelector("#music");
    addMusicSection(section, music);
}
function showMusic(musics)
{
    const section = document.querySelector("#music");
    console.log(section);


    for (let i = 0; i < musics.length; i++)
    {
        const music = music[i];
        addMusicSection(section, music);
    }
}

function addMusicSection(section, music)
{

    section.innerHTML += `<div class="music">
            <h2>${music.title}</h2>
            <p>ID #${music.id}</p>
        </div>`;
}
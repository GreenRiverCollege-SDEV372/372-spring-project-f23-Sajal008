//begin the pasge loade

window.onload = async function() {
    //fetch the data
    const uri = "http://localhost:8080/api/v1/music/all";
    const config = {
        method: 'get'
    }

    const response = await fetch(uri, config);
    const data = await response.json();
    showMusic(data);

    function showMusic(music)
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

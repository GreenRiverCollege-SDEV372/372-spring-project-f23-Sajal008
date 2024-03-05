//begin the pasge loade

window.onload = async function() {
    //fetch the data
    const uri = "http://localhost:3000/api/v1/music/all";
    const config = {
        method: 'get'
    }

    const response = await fetch(uri, config);
    const data = await response.json();
    showMusic(data);

    function showMusic(movies)
    {
        const section = document.querySelector("#music");
        console.log(section);


        for (let i = 0; i < movies.length; i++)
        {
            const movie = movies[i];
            addMusicSection(section, movie);
        }
    }

    function addMusicSection(section, movie)
    {
        section.innerHTML += `<div class="movie">
            <h2>${music.title}</h2>
            <p>ID #${music.id}</p>
            <p>Artist: ${music.artist}</p>
        </div>`;
    }}

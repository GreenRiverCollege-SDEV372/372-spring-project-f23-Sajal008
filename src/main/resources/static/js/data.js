// Fetch music data
async function fetchMusicData() {
    try {
        const response = await fetch("http://localhost:8080/api/v1/music/all");
        if (!response.ok) {
            throw new Error("Failed to fetch music data");
        }
        return await response.json();
    } catch (error) {
        console.error("Error fetching music data:", error);
        return [];
    }
}

// Add new music
async function addMusic(title, genre) {
    try {
        const response = await fetch("http://localhost:8080/api/v1/music", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ title, genre })
        });
        if (!response.ok) {
            throw new Error("Failed to add new music");
        }
        return await response.json();
    } catch (error) {
        console.error("Error adding new music:", error);
        return null;
    }
}

// Update existing music
async function updateMusic(id, title, genre) {
    try {
        const response = await fetch(`http://localhost:8080/api/v1/music/${id}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({ title, genre })
        });
        if (!response.ok) {
            throw new Error("Failed to update music");
        }
        return true;
    } catch (error) {
        console.error("Error updating music:", error);
        return false;
    }
}

// Delete existing music
async function deleteMusic(id) {
    try {
        const response = await fetch(`http://localhost:8080/api/v1/music/${id}`, {
            method: "DELETE"
        });
        if (!response.ok) {
            throw new Error("Failed to delete music");
        }
        return true;
    } catch (error) {
        console.error("Error deleting music:", error);
        return false;
    }
}

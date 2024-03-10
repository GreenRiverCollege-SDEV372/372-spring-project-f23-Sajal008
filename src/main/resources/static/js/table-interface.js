// Wait until the page finishes loading
window.onload = function() {
    // Select all edit links and assign click event listeners
    const editLinks = document.querySelectorAll('.edit');
    for (const link of editLinks) {
        link.onclick = handleEditClick;
    }

    // Select all delete links and assign click event listeners
    const deleteLinks = document.querySelectorAll('.delete');
    for (const link of deleteLinks) {
        link.onclick = handleDeleteClick;
    }
}

// Function to handle delete link clicks
function handleDeleteClick(evt) {
    // Retrieve the delete link and its parent row
    const deleteLink = evt.target;
    const row = deleteLink.parentElement.parentElement;

    // Extract the ID of the record from the first cell
    const id = row.children[0].innerHTML;

    //Send a fetch request to delete the record
    fetch(`/api/records/${id}`, {
        method: 'DELETE',
     })
    .then(response => {
         if (response.ok) {
             // If deletion is successful, remove the row from the table
             row.remove();
         } else {
             console.error('Failed to delete record');
         }
     })
     .catch(error => console.error('Error:', error));

    row.remove();
}

// Function to handle edit link clicks
function handleEditClick(evt) {
    // Retrieve the edit link and its parent row
    const editLink = evt.target;
    const row = editLink.parentElement.parentElement;

    // Extract the ID and current values of the record
    const id = row.children[0].innerHTML;
    const species = row.children[2].innerHTML;
    const location = row.children[4].innerHTML;

    // Replace the text with input fields for editing
    row.children[2].innerHTML = `<input type="text" id="species" value="${species}">`;
    row.children[4].innerHTML = `<input type="text" id="location" value="${location}">`;
}

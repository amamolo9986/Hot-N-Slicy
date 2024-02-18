document.addEventListener('DOMContentLoaded', function() {
    // Select all textareas inside update forms
    var textareas = document.querySelectorAll('#updateForm textarea');

    // Attach keyup event listener to each textarea
    textareas.forEach(function(textarea) {
        textarea.addEventListener('keyup', function(event) {
            // Check if the pressed key is Enter
            if (event.key === 'Enter') {
                event.preventDefault();
                // Focus on the next element (submit button)
                textarea.form.querySelector('#updateButton').focus();
            }
        });
    });
});
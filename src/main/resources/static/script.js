const submitBtn = document.getElementById('submitBtn');
const bookTitleInput = document.getElementById('bookTitle');
const bookList = document.getElementById('bookList');

// 1. Function to fetch and display all books from Java backend
async function loadBooks() {
    try {
        const response = await fetch('/books');
        const books = await response.json();

        // Clear the list first so we don't duplicate items
        bookList.innerHTML = "";

        // Loop through every book Java sends back and create an HTML <li> for it
        books.forEach(book => {
            const li = document.createElement('li');
            li.textContent = book.title; // assuming your Java entity has a 'title' field
            bookList.appendChild(li);
        });

    } catch (error) {
        console.error("Could not load books:", error);
    }
}

// Load the books the second the page opens
loadBooks();

// 2. Listen for when the user clicks the "Add Book" button
submitBtn.addEventListener('click', async function() {
    const titleText = bookTitleInput.value.trim();

    if (titleText === "") {
        alert("Please enter a book title!");
        return;
    }

    const newBook = { title: titleText };

    try {
        const response = await fetch('/books', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(newBook)
        });

        if (response.ok) {
            bookTitleInput.value = ""; // Clear the input box
            loadBooks(); // 🔄 Instantly reload the book list from Java!
        } else {
            alert("Something went wrong on the Java backend.");
        }

    } catch (error) {
        console.error("Error connecting to backend:", error);
        alert("Could not connect to Java backend. Is your Spring Boot app running?");
    }
});
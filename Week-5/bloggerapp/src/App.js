import { useState } from "react";

import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";

function App() {

    const [page, setPage] = useState("book");

    // Method 1 : Element Variable

    let component;

    if (page === "book") {

        component = <BookDetails />;

    }
    else if (page === "blog") {

        component = <BlogDetails />;

    }
    else {

        component = <CourseDetails />;

    }

    return (

        <div style={{ textAlign: "center" }}>

            <h1>Blogger App</h1>

            <button onClick={() => setPage("book")}>
                Book
            </button>

            <button onClick={() => setPage("blog")}>
                Blog
            </button>

            <button onClick={() => setPage("course")}>
                Course
            </button>

            <hr />

            {component}

        </div>

    );

}

export default App;
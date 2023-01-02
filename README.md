# kotlin-khtml
Small HTML DSL in Kotlin

## Usage

- A Bootstrap 5 form
```kotlin
val html = html {
    head {
        title("Hello world!")
        link("https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css") {
            attr("integrity", "sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD")
            attr("crossorigin", "anonymous")
        }
        script("https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js") {
            attr("integrity", "sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN")
            attr("crossorigin", "anonymous")
        }
    }
    body {
        div("container") {

            h1("Headline 1")
            h2("Headline 2")
            h3("Headline 3")
            h4("Headline 4")
            
            form("", "get") {
                div("md-3") {
                    label("q", "form-label") {
                        text = "Input query..."
                    }
                    input("search", "q", "form-control") {
                        attr("name", "q")
                    }
                    div("form-text") {
                        text = "Your input is private with us"
                    }
                }
                div("md-3") {
                    button("submit", "btn btn-primary") {
                        text = "Search"
                    }
                }
            }
        }
    }
}
val text = html.toString()
```
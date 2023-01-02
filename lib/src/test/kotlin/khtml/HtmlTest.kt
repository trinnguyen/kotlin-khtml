package khtml

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class HtmlTest {

    @Test
    fun testTitleOnly() {
        assertEquals(
        """
        <!DOCTYPE html>
        <html>
        <head>
        <title>Hello world</title>
        </head>
        <body />
        </html>
        """.trimIndent(), html {
            head {
                title("Hello world")
            }
        }.toString())
    }

    @Test
    fun testTitleBody() {
        assertEquals(
            """
        <!DOCTYPE html>
        <html>
        <head>
        <title>Hello world</title>
        </head>
        <body>
        <h1>Headline</h1>
        </body>
        </html>
        """.trimIndent(), html {
                head {
                    title("Hello world")
                }
                body {
                    h1("Headline")
                }
            }.toString())
    }
}
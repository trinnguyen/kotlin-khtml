package khtml

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class HtmlEleTest {

    @Test
    fun testEmptyTag() {
        assertEquals("<br />", HtmlEle("br").toString())
    }

    @Test
    fun testTextTag() {
        assertEquals("<p>This is para</p>", p { text = "This is para" }.toString())
    }

    @Test
    fun testDivWithPTag() {
        assertEquals("<div>\n<p>This is para</p>\n</div>", div { p("This is para") }.toString())
    }
}
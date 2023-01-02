package khtml

class Html: HtmlEle("html") {

    val headEle = HtmlEle("head")

    val bodyEle = HtmlEle("body")

    init {
        add(headEle)
        add(bodyEle)
    }

    override fun toString(): String {
        return "<!DOCTYPE html>\n" + super.toString()
    }
}

// free functions
fun html(p: Html.() -> Unit): Html {
    return Html().also(p)
}

fun Html.head(p: HtmlEle.() -> Unit) {
    p(headEle)
}

fun Html.body(p: HtmlEle.() -> Unit) {
    p(bodyEle)
}
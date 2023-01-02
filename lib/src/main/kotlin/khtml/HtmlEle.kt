package khtml

open class HtmlEle(val tag: String, var text: String = "", val content: MutableList<HtmlEle> = mutableListOf()) {

    val mapAttrs = mutableMapOf<String, String>()

    var alwaysKeepEndTag = false

    fun add(ele: HtmlEle) {
        content.add(ele)
    }

    fun attr(key: String, value: String) {
        if (value.isNotBlank()) {
            mapAttrs[key] = value
        }
    }

    override fun toString(): String {
        var prefix = tag
        if (mapAttrs.isNotEmpty()) {
            val str = mapAttrs.map { entry ->
                "${entry.key}=\"${entry.value}\""
            }.joinToString(" ")
            prefix += " $str"
        }

        // no content
        if (!alwaysKeepEndTag && text.isBlank() && content.isEmpty()) {
            return "<$prefix />"
        }

        // having text or content
        val sep = if (content.isNotEmpty()) { "\n" } else { "" }
        val contentText = (text + content.joinToString("\n")).trim()
        return sequenceOf("<$prefix>", contentText, "</$tag>").joinToString(sep)
    }
}

fun HtmlEle.tag(tag: String, text: String = "", p: HtmlEle.() -> Unit = {}) {
    this.add(HtmlEle(tag, text).also(p))
}

fun HtmlEle.tag(tag: String, p: HtmlEle.() -> Unit) {
    tag(tag, "", p)
}

fun div(c: HtmlEle.() -> Unit): HtmlEle {
    return HtmlEle("div").also(c)
}

fun p(c: HtmlEle.() -> Unit): HtmlEle {
    return HtmlEle("p").also(c)
}

fun HtmlEle.div(clazz: String = "", p: HtmlEle.() -> Unit) {
    tag("div", "") {
        attr("class", clazz)
        p(this)
    }
}

fun HtmlEle.h1(text: String) {
    this.tag("h1", text)
}

fun HtmlEle.h2(text: String) {
    this.tag("h2", text)
}

fun HtmlEle.h3(text: String) {
    this.tag("h3", text)
}

fun HtmlEle.h4(text: String) {
    this.tag("h4", text)
}

fun HtmlEle.p(text: String, c: HtmlEle.() -> Unit = {}) {
    this.tag("p", text, c)
}

fun HtmlEle.span(text: String, c: HtmlEle.() -> Unit = {}) {
    this.tag("span", text, c)
}

fun HtmlEle.ul(c: HtmlEle.() -> Unit) {
    this.tag("ul", c)
}

fun HtmlEle.li(text: String = "", c: HtmlEle.() -> Unit = {}) {
    this.tag("li", text, c)
}

fun HtmlEle.ol(c: HtmlEle.() -> Unit) {
    this.tag("ol", c)
}
fun HtmlEle.strong(text: String) {
    this.tag("strong", text)
}

fun HtmlEle.a(text: String, link: String, c: HtmlEle.() -> Unit = {}) {
    this.tag("a", text) {
        attr("href", link)
        c(this)
    }
}

fun HtmlEle.title(text: String) {
    this.tag("title", text)
}

fun HtmlEle.link(href: String, rel: String = "stylesheet", c: HtmlEle.() -> Unit) {
    this.tag("link") {
        attr("href", href)
        attr("rel", rel)
        c(this)
    }
}

fun HtmlEle.script(src: String, c: HtmlEle.() -> Unit) {
    this.tag("script") {
        alwaysKeepEndTag = true
        attr("src", src)
        c(this)
    }
}

// FORM
fun HtmlEle.form(action: String = "", method: String = "get", c: HtmlEle.() -> Unit) {
    tag("form") {
        attr("action", action)
        attr("method", method)
        c(this)
    }
}
fun HtmlEle.input(type: String, id: String = "", clazz: String = "", c: HtmlEle.() -> Unit = {}) {
    this.tag("input") {
        attr("type", type)
        attr("id", id)
        attr("class", clazz)
        c(this)
    }
}

fun HtmlEle.label(forId: String, clazz: String = "", c: HtmlEle.() -> Unit = {}) {
    this.tag("label") {
        attr("for", forId)
        attr("class", clazz)
        c(this)
    }
}

fun HtmlEle.button(type: String, clazz: String = "", c: HtmlEle.() -> Unit = {}) {
    this.tag("button") {
        attr("type", type)
        attr("class", clazz)
        c(this)
    }
}

fun HtmlEle.i(clazz: String = "") {
    this.tag("i") {
        alwaysKeepEndTag = true
        attr("class", clazz)
    }
}

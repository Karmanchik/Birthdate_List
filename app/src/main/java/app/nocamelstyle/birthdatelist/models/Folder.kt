package app.nocamelstyle.birthdatelist.models

class Folder(
    var id: Int,
    var name: String,
    var author: Int,
    var members: List<Int>,
    var description: String
)
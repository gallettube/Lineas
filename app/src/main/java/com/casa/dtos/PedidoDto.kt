package com.casa

class PedidoDto {
    var date: String = ""
    var line: String = ""
    constructor() {}
    constructor(date: String, line: String) {
        this.date = date
        this.line = line
    }
}
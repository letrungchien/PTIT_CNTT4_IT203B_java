package Session7.Lythuyet

class Product {
    var proId: String? = null
    var proName: String? = null
    var proPrice: Double = 0.0

    constructor()

    constructor(proId: String?, proName: String?, proPrice: Double) {
        this.proId = proId
        this.proName = proName
        this.proPrice = proPrice
    }
}
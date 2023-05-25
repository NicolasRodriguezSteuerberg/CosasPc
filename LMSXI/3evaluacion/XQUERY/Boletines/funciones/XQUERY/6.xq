let $max := max(/bookstore/book/price)
let $min := min(/bookstore/book/price)

return
  <resultado>
    <max>{$max}</max>
    <min>{$min}</min>
  </resultado>
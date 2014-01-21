(ns
  ^{:author Jared}
  org.bytescale.datastructures.spec.bag
  )

(defprotocol Bag
  "An unordered collection with the ability to "
  (add-item [this item]
    "Add an item")
  (is-empty? [this]
    "Is the bag empty?")
  (num-items [this]
    "How many items in the bag?"))

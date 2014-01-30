(ns
  ^{:author Jared}
  org.bytescale.datastructures.standard-bag
  (:import [clojure.lang ISeq IPersistentCollection Indexed RT]))

(deftype StandardBag [initial]
  IPersistentCollection
  (seq [self]
    (if (seq initial)
      self
      nil
      )
    )
  (cons [self item]
    (clojure.lang.RT/cons item (StandardBag. initial))
    )
  (empty [self]
    (StandardBag. [])
    )
  (equiv [self item]
    (if (instance? StandardBag item)
      (and (= initial (.initial item)))
      false)
    )

  ISeq
  (first [self]
    (first initial)
    )
  (next [self]
    (next initial)
    )
  (more [self]
    (rest initial)
    )

  Indexed
  (nth [this i]
    (nth initial i)
    )
  (nth [this i not-found]
    (nth initial i not-found)
    )
  (count [this]
    (count initial))
  Object
  (toString [self] (str "StandardBag containing: " (seq initial)))
  )

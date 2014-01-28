(ns
  ^{:author Jared}
  org.bytescale.datastructures.standard-bag
  (:import [clojure.lang ISeq IPersistentCollection Indexed]))

(deftype StandardBag [initial]
  IPersistentCollection
  (seq [self]
    (if (seq initial)
      self
      nil
      )
    )
  (cons [self item]
    (conj (StandardBag. initial) item)
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
  Object
  (toString [self] (str "StandardBag containing: " initial))
  )

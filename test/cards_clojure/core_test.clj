(ns cards-clojure.core-test
  (:require [clojure.test :refer :all]
            [cards-clojure.core :refer :all]))

(def hand-1 #{{:suit :clubs
               :rank 2}
              {:suit :clubs
               :rank 3}
              {:suit :clubs
               :rank 4}
              {:suit :clubs
               :rank 5}})

(def hand-2 #{{:suit :diamonds
              :rank 2}
             {:suit :clubs
              :rank 3}
             {:suit :clubs
              :rank 4}
             {:suit :clubs
              :rank 5}})

(deftest flush-test
  (testing "flush returns true if the hand is a flush"
    (is (= true (flush? hand-1)))
    (is (= false (flush? hand-2)))))

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

(def hand-3 #{{:suit :diamonds
               :rank 2}
              {:suit :clubs
               :rank 2}
              {:suit :clubs
               :rank 4}
              {:suit :diamonds
               :rank 4}})

(def hand-4 #{{:suit :diamonds
               :rank 2}
              {:suit :clubs
               :rank 2}
              {:suit :spades
               :rank 2}
              {:suit :diamonds
               :rank 4}})

(def hand-5  #{{:suit :diamonds
               :rank 10}
              {:suit :diamonds
               :rank 9}
              {:suit :diamonds
               :rank 8}
              {:suit :diamonds
               :rank 7}})
(def hand-6  #{{:suit :diamonds
                :rank 4}
               {:suit :clubs
                :rank 4}
               {:suit :spades
                :rank 4}
               {:suit :hearts
                :rank 4}})


(deftest flush-test
  (testing "testing all the hand variations to see if they work"
    (is (= true (flush? hand-1)))
    (is (= false (flush? hand-2)))
    (is (= true (straight? hand-2)))
    (is (= true (two-pair? hand-3)))
    (is (= true (three-of-a-kind? hand-4)))
    (is (= true (straight-flush? hand-5)))
    (is (= true (four-of-a-kind? hand-6)))))



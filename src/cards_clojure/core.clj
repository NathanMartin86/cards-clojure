(ns cards-clojure.core
  (:gen-class))

(def suits [:clubs :spades :hearts :diamonds])
(def ranks (range 1 14))
;(def rank-names {1 :ace, 11 :Jack, 12 :Queen, 13 :King})

(defn create-deck []
  (set (for [suit suits
             rank ranks]
         {:suit suit
          :rank rank})))

(defn create-hands [deck]
  (set (for [c1 deck
             c2 (disj deck c1)
             c3 (disj deck c1 c2)
             c4 (disj deck c1 c2 c3)]
         #{c1 c2 c3 c4})))

(defn flush? [hand]
  (= 1 (count (set (map :suit hand)))))

(defn most-popular-numbers
  [hand] (sort > (map second (frequencies (map second hand)))))

(defn straight? [hand]
  (let [[min-value :as sorted] (sort (map :rank hand))]
    (= sorted (take 4 (iterate inc min-value)))))

(defn four-of-a-kind? [hand]
  (= 1 (count (set (map :rank hand)))))

(defn three-of-a-kind? [hand]
  (== (apply max (vals (frequencies (map :rank hand))))3))

(defn two-pair? [hand]
  (= '(2 2) (take 2 (most-popular-numbers hand))))

(defn straight-flush? [hand]
  (and (straight? hand) (flush? hand)))


(defn -main
  [& args]

  (time (let [deck (create-deck)
                hands (create-hands deck)
                hands (filter flush? hands)]
            (println (count hands)))))

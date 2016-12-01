(ns interview-questions.core
  (require [clojure.string :as s]))

;;;;;;;;;;;
;; FizzBuzz

;; Print 1 to 100
;; (print (range 100)) ;; nope...
;; (print (map inc (range 100))) ;; Yep

;; True and false for the 3's
;(map #(= 0 (mod % 3)) (map inc (range 100)))

;; Fizz and Number for the 3's
;(map #(if (= 0 (mod % 3)) "Fizz" %) (range 1 101))

;; Fizz and Buzz
;(map #(cond (= 0 (mod % 3)) "F" (= 0 (mod % 5)) "B") (range 1 101))

;; Fizz, Buzz, FizzBuzz
;(map
; #(cond
;    (= 0 (mod % 15)) "FizzBuzz"
;    (= 0 (mod % 3)) "Fizz"
;    (= 0 (mod % 5)) "Buzz"
;    :else %) (range 1 101))


;; Time to do it less bad

(defn divides?
  "Determine whether or not a number (n) divides another (x)"
  [n x]
  (= 0 (mod n x)))

;(divides? 3 15) ;15 doesn't divide 3
;(divides? 30 15) ;15 does divide 30

;(map
; #(cond
;    (divides? % 15) "FizzBuzz"
;    (divides? % 5)  "Buzz"
;    (divides? % 3)  "Fizz"
;    :else %) (range 1 101))

;; lazyify fizzbuzz
(def fizzbuzz
  (map
   #(cond
      (divides? % 15) "FizzBuzz"
      (divides? % 5)  "Buzz"
      (divides? % 3)  "Fizz"
      :else %) (map inc (range 100))))
;; (take 100 fizzbuzz)


;;;;;;;;;;;;;;;;;;;
;; Reverse a string

(reduce str (reverse "Hello, World!"))

;; Step one, reverse the elements of a collection
;(reduce conj '() "hello!")

;; Stringify
;(apply str (reduce conj '() "hello"))

(defn my-reverse
  "Reverses a string"
  [s]
  (apply str
         (reduce conj '() s)))

;(my-reverse "hello")


;;;;;;;;;;;;;
;; Palindrome

;; Racecar
;; Moon noom
;; Good night thgin doog

;; make it lowercase
;(s/lower-case "AFGAGF")

;; Reverse it
;(my-reverse (s/lower-case "Hello"))

;; Compare two strings
;(= "hello" "asfg")

(defn palindrome?
  "Determines whether a string (s) is a palindrome or not"
  [s]
  (= (s/lower-case s) (my-reverse (s/lower-case s))))

;(palindrome? "Racecar")


(defn -main
  "I don't do a whole lot."
  []
  (println "Hello, World!"))

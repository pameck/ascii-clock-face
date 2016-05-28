(defproject ascii-clock "0.1.0-SNAPSHOT"
  :description "You put in your time in militar format, I'll print a clock face using h's, o's, m's and sometimes x's."
  :url "http://github.com/pameck/ascii-clock"
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

import groovyx.gpars.GParsPool

/**
 * Shows lazy nature of the anyParallel() method. Once a positive result is obtained no more elements are going to be processed.
 */

def n = [15, 4, 3, 4, 10]
GParsPool.withPool(3) {pool ->
    def k = n.anyParallel {t ->
        println "$t started"
        sleep t * 1000
        println "$t ended"
        true
    }
    println k
}
println "all ended"
# Web_Crawler
Home assignment from 2. year bachelor degree


# Basic

    Chosen to Overload functionality of MyEngine, this is just meant for performance, not reusability.

    This implementation of a webCrawler is meant to be quick and memory efficient. The end goal is to store data in a
    manner that has a low total of eexpanded memory, and a low lookup time for searches.
    As indexing and searching is done sequentially.

    Takes a string and crawls to a default or given number of couplings are obtained
    I also short down every links prefix with "http://" to theoretically save more memory.
    JVMs GC is hard to fine tune, and is often beyond programmers authority.

# Cleanup
    I've chosen to have null all other lists and sets whe I finish building my search index.

    Does visit long links, though this maxes slower. But is a better scan of all material. (Nothing
    is overlooked.)

# Traversing order
    This engine implements both DepthFirst and BreadthFirst Expansion of nodes.
    The implementation deals with duplicates. i.e it stores one instance of each.

    Did not encapsulate links in queue or stack, if one would like to alter order on something else.
    The change would be easy to implement.

# Optimization
    As mentioned, string shortening. Would have made string with domain and path/data from the url.
    and help JVM reuse domain part of strings as few times as possible. But was hard to read improvements on actual
    implementation, though there is the theoretic improvement.
    There is a method splitUrl added into the implementation, never used. But illustrates how this concept can be used
    to (in other languages or circumstances like c, such an implementation where direct managment of memory is done.)

    Due to circumstance with how WebPageReader deliver data, I've reassembled data into hashed structures
    to make searching the index easier and faster.

    Given some basic sizes to the maps and sets after both a little empirical testing on my own to find fitting numbers.

    I've also done a lot of testing with try catch directly with add, instead of trying with and if statement first.
    As .add() does this inside and returns a bool. Speed was upped quite a bit but taken out again to follow good
    code ethics.

# Remarks
	JVM caches strings which cannot be depleted with calls to gc, this may give different memory usage than in other languages like C or C++.
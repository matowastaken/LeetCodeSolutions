class Solution(object):
    def trailingZeroes(self, n):
        """
        :type n: int
        :rtype: int
        """
        number_of_5 = 0                     # this will be the number of times 5 is a factor in n!
        for i in range(5, n + 1, 5):        # iterate through all factors of n!
            number_of_5 += 1
            while (i // 5) % 5 == 0:   # compute the number of times 5 is a factor for each number from 1 to n
                number_of_5 += 1
                i //= 5
        return number_of_5                  # return the number of times 5 is a factor in n!


solution = Solution()
print(solution.trailingZeroes(10))

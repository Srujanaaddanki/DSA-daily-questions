<h2><a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock">121. Best Time to Buy and Sell Stock</a></h2><h3>Easy</h3><hr><p>You are given an array <code>prices</code> where <code>prices[i]</code> is the price of a given stock on the <code>i<sup>th</sup></code> day.</p>

<p>You want to maximize your profit by choosing a <strong>single day</strong> to buy one stock and choosing a <strong>different day in the future</strong> to sell that stock.</p>

<p>Return <em>the maximum profit you can achieve from this transaction</em>. If you cannot achieve any profit, return <code>0</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> prices = [7,1,5,3,6,4]
<strong>Output:</strong> 5
<strong>Explanation:</strong> Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> prices = [7,6,4,3,1]
<strong>Output:</strong> 0
<strong>Explanation:</strong> In this case, no transactions are done and the max profit = 0.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= prices.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= prices[i] &lt;= 10<sup>4</sup></code></li>
</ul>


DryRun:

<img width="673" height="442" alt="image" src="https://github.com/user-attachments/assets/67f4a276-2ba3-4043-8bca-d817e9b6ab3f" />
<img width="697" height="472" alt="image" src="https://github.com/user-attachments/assets/3a2e95f2-49ff-464a-9c10-a3cc2a8ee260" />

The Loop Ends
The loop runs out of elements and terminates. The method immediately returns maxProfit, which is safely holding 5.

Why this structure is so brilliant:

By evaluating the if-else branch day-by-day, the code inherently guarantees that you can only sell on a day that comes after you bought. Because minPrice only reflects the lowest price seen up to that specific index, you can never accidentally calculate a profit using a low price from the future!







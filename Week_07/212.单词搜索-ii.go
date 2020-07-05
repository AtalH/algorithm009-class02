/*
 * @lc app=leetcode.cn id=212 lang=golang
 *
 * [212] 单词搜索 II
 */

// @lc code=start
func findWords(board [][]byte, words []string) []string {
	if len(words) == 0 || len(board) == 0 || len(board[0]) == 0 {
		return []string{}
	}
	trie := Constructor()
	for _, word := range words {
		trie.Insert(word)
	}
	result := make([]string, 0)
	for i := 0; i < len(board); i++ {
		for j := 0; j < len(board[i]); j++ {
			dfs(board, i, j, trie, &result)
		}
	}
	return result
}

var dx = []int{-1, 1, 0, 0}
var dy = []int{0, 0, -1, 1}
var usedFlag byte = '#'

func dfs(board [][]byte, i int, j int, trie *Trie, result *[]string) {
	if i < 0 || j < 0 || i == len(board) || j == len(board[i]) {
		return
	}
	ijTemp := board[i][j]
	if ijTemp == usedFlag || !trie.contains(ijTemp) {
		return
	}
	node := trie.get(ijTemp)
	if node.Val != "" {
		*result = append(*result, node.Val)
		node.Val = ""
	}
	board[i][j] = usedFlag
	// 4 向
	for d := 0; d < 4; d++ {
		x, y := i + dx[d], j + dy[d]
		if x >=0 && x < len(board) && y >=0 && y < len(board[0]) && board[x][y] != usedFlag {
			dfs(board, x, y, node, result)
		}
	}
	board[i][j] = ijTemp
}

type Trie struct {
	Links []*Trie
	Val string
}

const c_R int = 26

/** Initialize your data structure here. */
func Constructor() *Trie {
	node := &Trie{Links: make([]*Trie, c_R)}
	return node
}

func (this *Trie) contains(ch byte) bool {
	return this.Links[ch - 'a'] != nil
}

func (this *Trie) get(ch byte) *Trie {
	return this.Links[ch - 'a']
}

func (this *Trie) put(ch byte, node *Trie)  {
	this.Links[ch - 'a'] = node
}


/** Inserts a word into the trie. */
func (this *Trie) Insert(word string)  {
	node := this
	for i := 0; i < len(word); i++ {
		ch := word[i]
		if !node.contains(ch) {
			node.put(ch, Constructor())
		}
		node = node.get(ch)
	}
	node.Val = word
}

// @lc code=end


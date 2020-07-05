/*
 * @lc app=leetcode.cn id=208 lang=golang
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
type Trie struct {
	Links []*Trie
	IsEnd bool
}

const c_R int = 26

/** Initialize your data structure here. */
func Constructor() Trie {
	node := Trie{Links: make([]*Trie, c_R), IsEnd: false}
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
			newNode := Constructor()
			node.put(ch, &newNode)
		}
		node = node.get(ch)
	}
	node.IsEnd = true
}

func (this *Trie) searchPrefix(word string) *Trie {
	node := this
	for i := 0; i < len(word); i++ {
		ch := word[i]
		if node == nil || !node.contains(ch) {
			return nil
		}
		node = node.get(ch)
	}
	return node
}


/** Returns if the word is in the trie. */
func (this *Trie) Search(word string) bool {
	node := this.searchPrefix(word)
	return node != nil && node.IsEnd == true
}


/** Returns if there is any word in the trie that starts with the given prefix. */
func (this *Trie) StartsWith(prefix string) bool {
	node := this.searchPrefix(prefix)
	return node != nil
}


/**
 * Your Trie object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Insert(word);
 * param_2 := obj.Search(word);
 * param_3 := obj.StartsWith(prefix);
 */
// @lc code=end


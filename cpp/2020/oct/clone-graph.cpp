class CloneGraph {
public:
    Node *cloneGraph(Node *node) {
        if (!node) {
            return NULL;
        }
        Node *copy = new Node(node->val, {});
        copies[node] = copy;
        queue < Node * > todo;
        todo.push(node);
        while (!todo.empty()) {
            Node *cur = todo.front();
            todo.pop();
            for (Node *neighbor : cur->neighbors) {
                if (copies.find(neighbor) == copies.end()) {
                    copies[neighbor] = new Node(neighbor->val, {});
                    todo.push(neighbor);
                }
                copies[cur]->neighbors.push_back(copies[neighbor]);
            }
        }
        return copy;
    }

private:
    unordered_map<Node *, Node *> copies;
};

class CloneGraph_ {
public:
    Node *cloneGraph(Node *node) {
        if (!node) {
            return NULL;
        }
        if (copies.find(node) == copies.end()) {
            copies[node] = new Node(node->val, {});
            for (Node *neighbor : node->neighbors) {
                copies[node]->neighbors.push_back(cloneGraph(neighbor));
            }
        }
        return copies[node];
    }

private:
    unordered_map<Node *, Node *> copies;
};
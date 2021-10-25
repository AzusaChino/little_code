
class Nd
{
public:
    Nd(int _val, int _min, Nd *_next) : val(_val), min(_min), next(_next) {}

private:
    int val;
    int min;
    Nd *next;
};

class MinStack
{
public:
    void push(int x)
    {
        if (!head)
        {
            head = new Nd(x, x, nullptr);
        }
        else
        {
            head = new Nd(x, min(x, head->min), head);
        }
    }
    void pop()
    {
        head = head->next;
    }

    int top()
    {
        return head->val;
    }
    int getMin()
    {
        return head->min;
    }

private:
    Nd *head;
};
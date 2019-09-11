/*
   Find merge point of two linked lists
   Node is defined as
   struct Node
   {
       int data;
       Node* next;
   }
*/
int count(Node* head)
    {
    Node* temp=head;
    int c=0;
    while(temp!=NULL)
        {
        temp=temp->next;
        c=c+1;
    }return c;
}
int find(Node* t1,Node *t2,int n1,int n2)
    {
    int d=n1-n2;
    for(int i=0;i<d;i++)
        t1=t1->next;
    while(t1 && t2)
        {
        if(t1->data==t2->data)
            return t1->data;
        t1=t1->next;
        t2=t2->next;
    }return 0;
}
int FindMergeNode(Node *headA, Node *headB)
{
    // Complete this function
    // Do not write the main method.
    Node* temp1=headA;
    Node* temp2=headB;
    int c1=count(temp1);
    int c2=count(temp2);
    if(c1>c2)
        {
        return find(temp1,temp2,c1,c2);
    }
    else
        return find(temp2,temp1,c2,c1);

return 0;}

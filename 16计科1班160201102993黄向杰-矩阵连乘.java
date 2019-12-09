void matrixMultiply(int * *a,int * *b,int * *c,int ra,int ca,int rb, int cb)
{
    if(ca!=rb)
        error("矩阵不可乘");
     for (int i=0;i<ra;i++)
        for(int j=0;j<cb;j++)
        {
            int sum=a[i][0]*b[0][j];
            for(int k=1;k<ca;k++)
                sum+=a[i][k]*b[k][j];
            c[i][j]=sum;
            }

}

void MatrixChain(int * p,int n, int * * m,int * * s)
{
    for(int i=1;i<=n;i++)
        m[i][i]=0;
    for(int r=2;r<=n;r++)
        for(int i=1;i<=n-r+1;i++)
        {
            int j =i+r-1;
            m[i][j]=m[i][j]+p[i-1]*p[i]*p[j];
            s[i][j]=i;
            for(int k=i+1;k<j;k++)
            {
                int t=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
                if(t<m[i][j])
                {
                    m[i][j]=t;
                    s[i][j]=k;
                }
            }
        }
}

void Traceback(int i,int j,int * *s)
{
    if(i==j)
        return;
    Traceback(i,s[i][j],s);
    Traceback(s[i][j]+1,j,s);
    cout <<"Multiply A"<<i<<","<<s[i][j];
    cout <<"and A"<<(s[i][j]+1<<","<<j<<endl;
}
-- [����] �������� ������ ���̺����� ��ȸ�ϴ� ����
select *
from dba_tables; 
from all_tables; --������ ����,��(view) // �ڽ��� ������ �� �ִ� ��������� table��
from user_tables; --������ ����,��(view)
--from tabs; --tablespace �� tabs
--[����] tabs?
--data dictionary(�ڷ����==�����ͻ��� == ������ ��ųʸ�) �̶�?
-- �� ���̺�,��
    
-- [����] dept ���̺� ������  ��ȸ�ϴ�����
select *
from dept;
select *
from emp;
select *
from bonus;
select *
from salgrade;
--count() ����Ŭ ���� �Լ� 
select count(*)
from dictionary;
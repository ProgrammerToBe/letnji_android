
insert into user values ('1', 'dad@mail.com');
insert into user values ('2', 'mum@mail.com');
insert into user values ('3', 'kid@mail.com');

insert into task_group values ('1', 'Home');
insert into task_group values ('2', 'Office');
insert into task_group values ('3', 'Car');
insert into task_group values ('4', 'Kids');
insert into task_group values ('5', 'Market');

insert into task_groups_members values (1, 1);
insert into task_groups_members values (1, 2);
insert into task_groups_members values (1, 3);
insert into task_groups_members values (1, 4);

insert into task_groups_members values (2, 1);
insert into task_groups_members values (1, 4);
insert into task_groups_members values (1, 5);

insert into task_groups_members values (3, 1);
insert into task_groups_members values (3, 4);

insert into task values (1, 'Take the garbage out', 'Garbage', 1);
insert into task values (2, 'Wash the sink', 'Kitchen', 2);
insert into task values (3, 'Repair the washing machine', 'Washing machine', 1);
insert into task values (4, 'Write the January report', 'Jan report', 1);
insert into task values (5, 'Ask for a raise', 'Bos', 1);
insert into task values (6, 'Check the engine', 'Engine', 1);
insert into task values (7, 'Do the math homework', 'Math', 3);
insert into task values (8, 'Check the math homework', 'Homework', 2);
insert into task values (9, '', 'Eggs', 2);
insert into task values (10, '', 'Milk', 2);
insert into task values (11, '', 'Fish', 2);

insert into task_groups_tasks values (1, 1);
insert into task_groups_tasks values (1, 2);
insert into task_groups_tasks values (1, 3);
insert into task_groups_tasks values (2, 4);
insert into task_groups_tasks values (2, 5);
insert into task_groups_tasks values (3, 6);
insert into task_groups_tasks values (4, 7);
insert into task_groups_tasks values (4, 8);
insert into task_groups_tasks values (5, 9);
insert into task_groups_tasks values (5, 10);
insert into task_groups_tasks values (5, 11);

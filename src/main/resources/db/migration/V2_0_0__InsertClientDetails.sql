insert  into oauth_client_details(client_id,resource_ids,client_secret,scope,
authorized_grant_types,web_server_redirect_uri,authorities,access_token_validity,refresh_token_validity,additional_information,autoapprove)
values ('clientId','resource-server-rest-api','secret','read'
,'password,authorization_code,refresh_token,client_credentials,implicit','https://www.getpostman.com/oauth2/callback','USER',10800,2592000,null,null);

insert into authority(name) values ('ADMIN');

insert into user(account_expired,account_locked,credentials_expired,enabled,password,user_name)
values (0,0,0,1,'admin1234','admin');
--insert ignore into `user_authority`(`authority_id`,`user_id`) values (1,1);





--insert into authority(name)
--values ('ADMIN');
--

--
--insert into user_authority(authority_id,user_id)
--values (1,1);
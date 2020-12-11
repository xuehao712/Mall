## Preface

`mall` project is an e-commerce system designed and developed using modern techniques.

## Introduction

`mall` project includes frontend system and admin management system based on SpringBoot+MyBatis.
Frontend Mall System includes: Home Display, Product Recommend, Product Search, Product Display, Cart, Order Process, Member Center, Customer Service, Helper Center.
Backend Mall System includes: Product Management, Order Management,Promotion Management, Operation management, Content Management, Statistical Reports, Financial Management, Authority Management, Settings and other modules.

### Project Demo

Frontend Project: `mall-admin`：https://github.com/xuehao712/Mall-Admin

Project Demo: [http://www.shawnzheng.com/](http://www.shawnzheng.com/)

### Structure

``` lua
mall
├── mall-common -- Tools and common code
├── mall-mbg -- MyBatisGenerator generate database code
├── mall-security -- SpringSecurity module
├── mall-admin -- Admin management api
├── mall-search -- Elasticsearch product search
├── mall-portal -- Frontend mall api
└── mall-demo -- test code
```

### Techniques

#### Backend

| Technique            | Description                | Website                                              |
| -------------------- | -------------------        | ---------------------------------------------------- |
| SpringBoot           | MVC framework              | https://spring.io/projects/spring-boot               |
| SpringSecurity       | Authorization              | https://spring.io/projects/spring-security           |
| MyBatis              | ORM framework              | http://www.mybatis.org/mybatis-3/zh/index.html       |
| MyBatisGenerator     | Data generate              | http://www.mybatis.org/generator/index.html          |
| PageHelper           | MyBatis pagination         | http://git.oschina.net/free/Mybatis_PageHelper       |
| Swagger-UI           | Document generate          | https://github.com/swagger-api/swagger-ui            |
| Elasticsearch        | Search Engine              | https://github.com/elastic/elasticsearch             |
| Redis                | Distributed cache          | https://redis.io/                                    |
| Druid                | Database connection pool   | https://github.com/alibaba/druid                     |
| JWT                  | JWT login support          | https://github.com/jwtk/jjwt                         |
| Lombok               | simplify Encapsulation     | https://github.com/rzwitserloot/lombok               |

#### Frontend

| Tech       | Detail                | Website                                |
| ---------- | --------------------- | -------------------------------------- |
| React      | Framework             | https://reactjs.org/                   |
| Antd       | UI Framework          | https://ant.design/                    |
| Axios      | HTTP Framework        | https://github.com/axios/axios         |
| recharts   | frontend UI           | https://recharts.org/en-US/            |
| Js-cookie  | cookie                | https://github.com/js-cookie/js-cookie |
| Material-UI| UI Framework          | https://material-ui.com/               |
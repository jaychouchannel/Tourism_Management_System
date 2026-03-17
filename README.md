# 🌏 旅游管理系统 (Tourism Management System)

> 一个基于 **Spring Boot + MyBatis-Plus + Vue 2 + MySQL** 构建的全栈旅游综合管理平台，涵盖景点浏览、酒店预订、餐厅预约、报团管理、票务订单、社区论坛等核心业务。

---

## 📑 目录

- [项目简介](#项目简介)
- [功能模块](#功能模块)
- [技术栈](#技术栈)
- [系统架构](#系统架构)
- [目录结构](#目录结构)
- [数据库说明](#数据库说明)
- [环境要求](#环境要求)
- [快速启动](#快速启动)
- [前端二次开发](#前端二次开发)
- [常见问题](#常见问题)

---

## 项目简介

旅游管理系统是一套面向旅游行业的综合性管理平台，由三部分组成：

| 模块 | 说明 |
|------|------|
| **后端 API** | Spring Boot RESTful 服务，提供所有业务接口 |
| **管理员后台** | Vue 2 + Element UI 构建的后台管理界面 |
| **用户前台** | Vue 2 + Element UI 构建的用户访问门户 |

---

## 功能模块

### 🏔️ 景区管理
- 热门景点列表（图片、票价、库存、位置、简介）
- 景点类型分类管理
- 景点评论 / 点赞 / 踩
- 景点收藏与浏览记录

### 🗺️ 旅游线路
- 线路信息管理（出发日期、费用、行程结构）
- 线路类型分类
- 旅游攻略发布与讨论
- 报团管理（导游分配、团费、出发日期）

### 🏨 酒店管理
- 酒店及客房信息（类型、规格、容纳人数）
- 在线客房预订（入住 / 退房时间）
- 酒店评论

### 🍽️ 餐厅管理
- 餐厅信息（类别、地址、营业楼层）
- 餐厅在线预约（人数、备注）
- 管理员审核预约流程

### 🎫 门票管理
- 门票订单创建与查询
- 支付状态跟踪
- 库存数量管理

### 👤 用户与社区
- 用户注册、登录、个人信息管理
- 论坛帖子发布与讨论
- 用户私信 / 聊天消息
- 好友系统（添加 / 管理好友）
- 收藏夹（景点、线路等）
- 新闻资讯浏览

### 🛠️ 管理员功能
- 数据统计仪表盘（ECharts 可视化）
- 所有业务实体的 CRUD 管理
- 餐厅预约审核
- 友情链接管理
- 系统配置

---

## 技术栈

### 后端

| 技术 | 版本 | 说明 |
|------|------|------|
| Spring Boot | 2.2.2.RELEASE | 后端主框架 |
| MyBatis-Plus | 2.3 | ORM 持久层 |
| MySQL | 5.7+ | 关系型数据库 |
| FastJson | 1.2.8 | JSON 序列化 |
| Hutool | 4.0.12 | 工具类库 |
| Apache POI | 3.x | Excel 导出 |
| Baidu AI SDK | 4.4.1 | AI 能力集成 |
| Alipay SDK | — | 支付宝支付（模板） |

### 前端

| 技术 | 版本 | 说明 |
|------|------|------|
| Vue.js | 2.6+ | 前端框架 |
| Element UI | 2.13+ | UI 组件库 |
| Vue Router | 3.x | 路由管理 |
| Vuex | 3.x | 状态管理 |
| Axios | 0.19+ | HTTP 请求 |
| ECharts | 5.4.1 | 数据可视化（管理端） |
| Swiper | 5.2.0 | 图片轮播 |
| vue-baidu-map | — | 百度地图集成 |
| Quill | — | 富文本编辑器 |

### 构建工具

| 工具 | 用途 |
|------|------|
| Maven 3 | 后端构建 |
| npm / cnpm | 前端包管理 |

---

## 系统架构

```
┌──────────────────────────────────────────────────────────────┐
│                        浏览器 / 客户端                        │
│          ┌─────────────────┐   ┌──────────────────┐          │
│          │  用户前台 (Vue2) │   │ 管理后台 (Vue2)  │          │
│          └────────┬────────┘   └────────┬─────────┘          │
└───────────────────┼─────────────────────┼────────────────────┘
                    │  HTTP / REST API    │
┌───────────────────▼─────────────────────▼────────────────────┐
│              Spring Boot 后端 (端口 8080)                      │
│   Controller → Service → DAO (MyBatis-Plus) → MySQL           │
│                                                               │
│   静态资源：/admin/dist/   /front/dist/   /upload/           │
└───────────────────────────────────────────────────────────────┘
                              │
                    ┌─────────▼──────────┐
                    │   MySQL 数据库      │
                    │   (travel 库)       │
                    └────────────────────┘
```

---

## 目录结构

```
Tourism_Management_System/
├── travel.sql                          # 数据库初始化脚本（含建库、建表、初始数据）
└── travel/                             # Spring Boot 主项目
    ├── pom.xml                         # Maven 依赖配置
    └── src/
        ├── main/
        │   ├── java/com/
        │   │   ├── SpringbootSchemaApplication.java   # 启动类
        │   │   ├── annotation/         # 自定义注解（@IgnoreAuth 等）
        │   │   ├── config/             # 配置类（MyBatis-Plus、拦截器、Alipay）
        │   │   ├── controller/         # REST 控制器（31 个）
        │   │   ├── dao/                # MyBatis-Plus Mapper 接口
        │   │   ├── entity/             # 实体类（model / view / vo）
        │   │   ├── interceptor/        # 请求拦截器（CORS、Token 校验）
        │   │   ├── service/            # 业务接口
        │   │   │   └── impl/           # 业务实现类
        │   │   └── utils/              # 工具类（分页、校验、协同过滤推荐等）
        │   └── resources/
        │       ├── application.yml     # 应用配置（数据库、端口等）
        │       ├── mapper/             # MyBatis XML 映射文件（30+ 个）
        │       ├── admin/admin/        # 管理员前端 Vue 项目
        │       │   ├── src/            # 源码
        │       │   ├── dist/           # 已构建产物（后端直接托管）
        │       │   └── package.json
        │       └── front/front/        # 用户前台 Vue 项目
        │           ├── src/
        │           ├── dist/
        │           └── package.json
        └── test/
```

---

## 数据库说明

数据库名：`travel`，共 **30 张表**（MySQL 5.7+）。

| 表名 | 说明 |
|------|------|
| `yonghu` | 用户信息 |
| `users` | 管理员账号 |
| `token` | 登录令牌 |
| `remenjingdian` | 热门景点 |
| `jingdianleixing` | 景点类型 |
| `discussremenjingdian` | 景点评论 |
| `lvyouxianlu` | 旅游线路 |
| `xianluleixing` | 线路类型 |
| `discusslvyouxianlu` | 线路评论 |
| `lvyougonglve` | 旅游攻略 |
| `discusslvyougonglve` | 攻略评论 |
| `baotuanxinxi` | 报团信息 |
| `daoyou` | 导游信息 |
| `jiudianxinxi` | 酒店信息 |
| `kefangleixing` | 客房类型 |
| `jiudianyuding` | 酒店预订 |
| `discussjiudianxinxi` | 酒店评论 |
| `meishicanting` | 美食餐厅 |
| `cantingyuyue` | 餐厅预约 |
| `discussmeishicanting` | 餐厅评论 |
| `menpiaodingdan` | 门票订单 |
| `news` | 新闻资讯 |
| `newstype` | 新闻类型 |
| `forum` | 论坛帖子 |
| `chatmessage` | 聊天消息 |
| `storeup` | 收藏记录 |
| `friend` | 好友关系 |
| `friendlink` | 友情链接 |
| `config` | 系统配置 |
| `qiujiu` | 求救/帮助信息 |

> 完整建表语句及初始数据见根目录 `travel.sql`。

---

## 环境要求

| 软件 | 版本要求 | 备注 |
|------|----------|------|
| JDK | 1.8（Java 8） | 必须 |
| Maven | 3.x | 必须 |
| MySQL | 5.7+ | 必须 |
| Node.js | 12+ | 仅前端二次开发时需要 |
| npm / cnpm | 配套版本 | 仅前端二次开发时需要 |

---

## 快速启动

### 第一步：导入数据库

启动 MySQL 后，执行根目录下的 `travel.sql`（会自动创建 `travel` 数据库并导入数据）：

```bash
mysql -u root -p < travel.sql
```

或通过 Navicat / DBeaver / MySQL Workbench 等客户端直接运行 `travel.sql`。

---

### 第二步：检查数据库配置

默认配置文件：`travel/src/main/resources/application.yml`

```yaml
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/travel?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
    username: root
    password: 123456
```

若数据库密码不是 `123456`，或需要修改主机地址，请编辑上述配置后再启动。

> ⚠️ **安全提示：** `useSSL=false` 会以明文传输数据库凭据，存在被网络监听的风险，**严禁用于生产环境**。部署到公网服务器时，请将其改为 `useSSL=true`，并为 MySQL 配置相应的 SSL/TLS 证书，以加密所有数据库连接。

---

### 第三步：启动后端

```bash
cd travel
mvn spring-boot:run
```

或在 **IntelliJ IDEA** 中：
1. **File → Open** 选择 `travel/` 目录（含 `pom.xml`）
2. 等待 Maven 下载依赖
3. 找到 `com.SpringbootSchemaApplication`，右键 → **Run**

后端启动成功后监听：`http://localhost:8080/travel`

---

### 第四步：访问系统

已构建完毕的前端静态资源由后端直接托管，无需额外操作：

| 页面 | 访问地址 |
|------|---------|
| **管理员后台** | http://localhost:8080/travel/admin/dist/index.html |
| **用户前台** | http://localhost:8080/travel/front/dist/index.html |

> Windows 环境下，后端启动时会自动弹出浏览器窗口。Linux / macOS 请手动打开上述链接。

#### 默认账号

| 角色 | 用户名 | 密码 |
|------|--------|------|
| 管理员 | `admin` | `admin` |
| 普通用户 | 注册后使用 | — |

---

## 前端二次开发

> 如不需要修改前端源码，可跳过此节。

### 管理员后台

```bash
cd travel/src/main/resources/admin/admin

# 安装依赖（推荐 cnpm 加速）
cnpm install   # 或 npm install

# 启动开发服务器（端口 8081，自动代理到后端 8080）
npm run serve

# 构建生产包（产物输出至 dist/，后端托管使用）
npm run build
```

**Windows 快捷脚本：**
- `1-install.bat` — 安装依赖
- `2-run.bat` — 启动开发服务器
- `3-build.bat` — 构建生产包

---

### 用户前台

```bash
cd travel/src/main/resources/front/front

cnpm install   # 或 npm install
npm run serve  # 开发模式
npm run build  # 构建生产包
```

**Windows 快捷脚本：** `install.bat` / `run.bat` / `build.bat`

---

## 常见问题

**Q：启动报数据库连接错误？**  
A：检查 MySQL 服务是否已启动；确认 `application.yml` 中的用户名、密码与实际 MySQL 一致；确认已通过 `travel.sql` 成功创建数据库。

**Q：端口 8080 已被占用？**  
A：修改 `application.yml` 中的 `server.port`，同时修改前端 `vue.config.js` 中 proxy 的目标端口。

**Q：前端页面空白或 404？**  
A：确认后端正常启动，且访问路径需包含 `/dist/index.html`，例如：  
`http://localhost:8080/travel/front/dist/index.html`

**Q：Windows 上 cnpm 不可用？**  
A：先执行以下命令安装：
```bash
npm install -g cnpm --registry=https://registry.npmmirror.com
```
或直接使用 `npm install` 替代 `cnpm install`。

**Q：文件上传失败？**  
A：`application.yml` 中已将上传大小上限设置为 300 MB，若仍失败请检查磁盘空间及服务器写权限。

**Q：Maven 依赖下载慢？**  
A：在 Maven `settings.xml` 中添加阿里云镜像：
```xml
<mirror>
  <id>aliyun</id>
  <mirrorOf>central</mirrorOf>
  <name>Aliyun Maven Mirror</name>
  <url>https://maven.aliyun.com/repository/public</url>
</mirror>
```

---

## 许可证

本项目仅供学习与参考使用。

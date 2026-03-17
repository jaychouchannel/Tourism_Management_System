# 🌍 Tourism Management System — 旅游管理系统

<p align="center">
  <img src="https://img.shields.io/badge/Spring%20Boot-2.2.2-brightgreen" alt="Spring Boot"/>
  <img src="https://img.shields.io/badge/MyBatis--Plus-2.3-blue" alt="MyBatis-Plus"/>
  <img src="https://img.shields.io/badge/Vue.js-2.x-42b883" alt="Vue.js"/>
  <img src="https://img.shields.io/badge/MySQL-5.7%2B-orange" alt="MySQL"/>
  <img src="https://img.shields.io/badge/Java-1.8-red" alt="Java"/>
  <img src="https://img.shields.io/badge/License-MIT-lightgrey" alt="License"/>
</p>

> 一个基于 **Spring Boot + MyBatis-Plus + Vue.js + MySQL** 构建的全功能旅游综合管理平台，涵盖景点、酒店、餐厅、线路、导游、门票、社区等核心业务。

---

## 📋 目录

- [项目简介](#-项目简介)
- [功能模块](#-功能模块)
- [技术栈](#-技术栈)
- [系统架构](#-系统架构)
- [环境要求](#-环境要求)
- [快速启动](#-快速启动)
- [使用 IntelliJ IDEA 打开项目](#-使用-intellij-idea-打开项目)
- [前端二次开发](#-前端二次开发可选)
- [目录结构](#-目录结构)
- [数据库说明](#-数据库说明)
- [常见问题](#-常见问题)

---

## 📖 项目简介

本系统是一套 **B2C 旅游综合管理平台**，面向普通用户提供旅游资讯与预订服务，同时为管理员提供全功能后台管理能力。系统包含三个主要端：

| 端 | 说明 |
|----|------|
| **管理员后台** | 数据管理、用户审核、订单处理、内容发布 |
| **用户前台** | 景点浏览、酒店/餐厅预订、购票、社区互动 |
| **后端 API** | Spring Boot RESTful 接口，统一对两端提供服务 |

---

## ✨ 功能模块

### 🏞️ 景点管理
- 热门景点信息的增删改查与分类管理
- 景点图片、介绍、评分展示
- 用户评价与讨论

### 🏨 酒店管理
- 酒店信息管理（名称、地址、设施、图片）
- 房间类型管理
- 酒店预订与订单跟踪
- 用户评论

### 🍽️ 餐厅管理
- 美食餐厅信息管理
- 餐厅预约系统
- 用户点评

### 🚌 旅游线路 & 导游
- 旅游线路信息管理（线路名称、费用、行程）
- 线路分类管理
- 导游信息（工号、专业领域、语言能力）
- 旅游攻略发布与分享

### 🎫 报团 & 门票
- 报团信息管理（出发日期、人数、费用）
- 门票订单创建与支付
- 支付宝集成（ispay 状态跟踪）

### 👥 用户管理
- 用户注册、登录、个人信息管理
- 基于 Apache Shiro 的角色权限控制
- Token 会话管理

### 💬 社区功能
- 论坛发帖与评论
- 用户私信（聊天消息）
- 好友系统
- 收藏夹

### 📰 内容管理
- 新闻资讯发布与分类
- 轮播图/Banner 配置
- 富文本编辑器支持（Quill Editor）

### 📊 管理员数据看板
- ECharts 数据可视化（订单趋势、用户统计）
- 内容审核（sfsh 审核字段）
- Excel 数据导入导出（Apache POI）

---

## 🛠️ 技术栈

### 后端

| 组件 | 技术 | 版本 |
|------|------|------|
| 核心框架 | Spring Boot | 2.2.2.RELEASE |
| 持久层 | MyBatis-Plus | 2.3 |
| 数据库 | MySQL | 5.7+ |
| 安全认证 | Apache Shiro | 1.3.2 |
| 构建工具 | Maven | 3.x |
| AI 集成 | Baidu AI API | — |
| 支付 | 支付宝 SDK | — |
| 工具库 | Hutool、Apache POI、FastJSON | — |

### 前端

| 端 | 框架 | UI 组件库 | 其他 |
|----|------|-----------|------|
| 管理员后台 | Vue 2.6.10 | Element UI 2.13.0 | ECharts 5、Axios |
| 用户前台 | Vue 2.6.11 | Element UI 2.15.5 | Swiper 5、百度地图、Quill |

---

## 🏗️ 系统架构

```
┌─────────────────────────────────────────────────────┐
│                   浏览器客户端                        │
│    管理员后台 (Vue 2 + Element UI + ECharts)          │
│    用户前台   (Vue 2 + Element UI + Swiper)           │
└────────────────────┬────────────────────────────────┘
                     │ HTTP / REST API
┌────────────────────▼────────────────────────────────┐
│              Spring Boot 2.2.2 (Tomcat)              │
│  ┌─────────────┐  ┌───────────┐  ┌──────────────┐   │
│  │  Controller │→ │  Service  │→ │     DAO      │   │
│  │  (REST API) │  │ (业务逻辑) │  │ (MyBatis+)  │   │
│  └─────────────┘  └───────────┘  └──────┬───────┘   │
│  ┌─────────────────────────────┐         │           │
│  │   Apache Shiro (认证/授权)   │         │           │
│  └─────────────────────────────┘         │           │
└─────────────────────────────────────────┼───────────┘
                                          │
┌─────────────────────────────────────────▼───────────┐
│                  MySQL 5.7+ (travel 数据库)           │
│            31 张核心业务表                             │
└─────────────────────────────────────────────────────┘
```

---

## ⚙️ 环境要求

| 工具 | 版本要求 | 说明 |
|------|---------|------|
| JDK | 1.8（Java 8） | 必须 |
| Maven | 3.x | 必须 |
| MySQL | 5.7+ | 必须 |
| Node.js | 12+ | 仅前端二次开发时需要 |
| npm / cnpm | — | 仅前端二次开发时需要 |

---

## 🚀 快速启动

### 第一步：导入数据库

启动 MySQL，然后执行根目录下的 `travel.sql`：

```bash
mysql -u root -p < travel.sql
```

也可在 Navicat / DBeaver 等客户端中直接运行 `travel.sql`。  
执行后将自动创建名为 `travel` 的数据库并写入初始化数据。

---

### 第二步：（可选）修改数据库配置

若 MySQL 用户名、密码或地址与默认不同，请编辑：

```
travel/src/main/resources/application.yml
```

```yaml
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/travel?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
    username: root
    password: 你的MySQL密码   # ← 按实际情况修改
```

> ⚠️ `useSSL=false` 仅适用于**数据库与应用同机运行**的本地开发场景。只要数据库通过网络访问（包括局域网），或部署到生产服务器，**必须**将 `useSSL=true` 并配置相应证书，以加密数据库连接，防止数据泄露。

---

### 第三步：启动后端

```bash
cd travel
mvn spring-boot:run
```

后端启动成功后，服务运行于：

```
http://localhost:8080/travel
```

---

### 第四步：访问系统

内置的已构建前端静态资源无需额外步骤，启动后直接访问：

| 页面 | 地址 |
|------|------|
| 🖥️ **管理员后台** | http://localhost:8080/travel/admin/dist/index.html |
| 🌐 **用户前台** | http://localhost:8080/travel/front/dist/index.html |

> Windows 环境下，后端启动时会**自动弹出浏览器**打开上述两个页面。  
> Linux / macOS 请手动复制链接到浏览器访问。

---

## 💡 使用 IntelliJ IDEA 打开项目

1. 打开 IntelliJ IDEA，选择 **File → Open**。
2. 选择仓库中的 **`travel`** 目录（即含有 `pom.xml` 的那一层）。
3. IDEA 会自动识别为 Maven 项目并下载依赖（首次可能需要几分钟）。
4. 依赖下载完成后，找到 `com.SpringbootSchemaApplication`，右键 → **Run**。

---

## 🎨 前端二次开发（可选）

如需修改前端源码，请进入对应子目录操作：

### 管理员前端（admin）

```bash
cd travel/src/main/resources/admin/admin

# 安装依赖（国内推荐 cnpm 加速）
cnpm install
# 或
npm install

# 启动开发服务器（端口 8081，自动代理后端 8080）
npm run serve

# 构建生产包（输出到 dist/，后端会直接使用）
npm run build
```

Windows 用户可直接双击批处理脚本：
- `1-install.bat` — 安装依赖
- `2-run.bat` — 启动开发服务器
- `3-build.bat` — 构建生产包

### 用户前台（front）

```bash
cd travel/src/main/resources/front/front

cnpm install
npm run serve   # 开发模式（端口 8082）
npm run build   # 构建生产包
```

---

## 📁 目录结构

```
Tourism_Management_System/
├── travel.sql                          # 数据库初始化脚本（31 张表）
├── README.md                           # 项目说明文档（本文件）
└── travel/                             # Spring Boot 后端主项目
    ├── pom.xml                         # Maven 项目配置
    └── src/main/
        ├── java/com/
        │   ├── SpringbootSchemaApplication.java  # 启动类
        │   ├── annotation/             # 自定义注解（LoginUser、IgnoreAuth 等）
        │   ├── config/                 # 配置类（Shiro、拦截器、Alipay 等）
        │   ├── controller/             # REST 控制器（31 个）
        │   ├── service/                # 业务逻辑层及实现
        │   ├── dao/                    # MyBatis-Plus Mapper 接口（31 个）
        │   ├── entity/                 # 实体类 / VO / View
        │   ├── interceptor/            # 请求拦截器（Token 鉴权）
        │   └── utils/                  # 工具类（加密、文件、推荐算法等）
        └── resources/
            ├── application.yml         # 应用配置（端口、数据源、MyBatis 等）
            ├── mapper/                 # MyBatis XML 映射文件（32 个）
            ├── admin/admin/            # 管理员前端 Vue 项目
            │   ├── src/                # Vue 源码
            │   └── dist/               # 已构建生产包（直接部署使用）
            └── front/front/            # 用户前台 Vue 项目
                ├── src/                # Vue 源码
                └── dist/               # 已构建生产包（直接部署使用）
```

---

## 🗄️ 数据库说明

数据库名称：**`travel`**，共 **31 张核心业务表**：

| 表名 | 中文说明 |
|------|---------|
| `yonghu` | 用户账号 |
| `users` | 系统用户（管理员等） |
| `daoyou` | 导游信息 |
| `remenjingdian` | 热门景点 |
| `jingdianleixing` | 景点分类 |
| `jiudianxinxi` | 酒店信息 |
| `kefangleixing` | 房间类型 |
| `jiudianyuding` | 酒店预订 |
| `meishicantin` | 美食餐厅 |
| `cantingyuyue` | 餐厅预约 |
| `lvyouxianlu` | 旅游线路 |
| `xianluleixing` | 线路类型 |
| `lvyougonglve` | 旅游攻略 |
| `baotuanxinxi` | 报团信息 |
| `menpiaodingdan` | 门票订单 |
| `news` | 新闻资讯 |
| `newstype` | 新闻分类 |
| `forum` | 论坛帖子 |
| `chatmessage` | 用户私信 |
| `storeup` | 收藏记录 |
| `discuss*` | 各实体评论表（景点/酒店/餐厅/线路/攻略）|
| `friend` / `friendlink` | 好友关系 |
| `token` | 会话令牌 |
| `config` | 系统配置 |

---

## ❓ 常见问题

**Q: 启动时报数据库连接错误？**  
A: 检查 MySQL 是否已启动，确认 `application.yml` 中的用户名、密码正确，并确保已成功执行 `travel.sql` 导入数据。

**Q: 端口 8080 被占用？**  
A: 修改 `application.yml` 中的 `server.port`，同时修改前端 `vue.config.js` 中 proxy 的目标地址为新端口。

**Q: 前端页面空白或返回 404？**  
A: 确保后端已正常启动，且访问路径正确：`http://localhost:8080/travel/admin/dist/index.html`（需完整路径，包含 `/dist/index.html`）。

**Q: Windows 上 cnpm 不可用？**  
A: 执行以下命令安装 cnpm，或直接用 `npm install` 替代：
```bash
npm install -g cnpm --registry=https://registry.npmmirror.com
```

**Q: Maven 下载依赖很慢？**  
A: `pom.xml` 中已配置阿里云 Maven 镜像加速，若仍然较慢，可手动在 `~/.m2/settings.xml` 中添加镜像：
```xml
<mirror>
  <id>aliyun</id>
  <mirrorOf>central</mirrorOf>
  <url>https://maven.aliyun.com/repository/central</url>
</mirror>
```

---

## 📄 许可证

本项目仅供学习与参考使用。

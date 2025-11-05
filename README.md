# Finance System - Cloud Native Microservices Architecture 🏦

A comprehensive, production-ready **cloud-native finance system** built with **Spring Boot** microservices architecture. Demonstrates modern distributed systems patterns including service discovery, messaging, configuration management, and observability.

## 📋 Overview

**Finance System** is a complete banking simulation featuring:
- Customer management
- Account management
- Payment processing
- Messaging layer for inter-service communication
- Cloud-native architecture patterns
- Comprehensive monitoring and observability

Perfect for learning microservices, Spring Cloud, distributed systems, and cloud-native application development.

## ✨ Features

### Core Functionalities
- 👤 **Customer Management** - Register and manage customers
- 💳 **Account Management** - Open and manage bank accounts
- 💰 **Payment Processing** - Send money between accounts
- 📨 **Event-Driven Architecture** - Redis-based messaging
- ⚙️ **Configuration Management** - Centralized config server
- 📊 **Monitoring** - Prometheus and Grafana integration

### Technical Features
- 🏗️ **Microservices Architecture** - Separate services for each domain
- 🔄 **Service Discovery** - Eureka-based service registration
- ⚖️ **Load Balancing** - Distributed load handling
- 🔐 **Security** - JWT authentication (planned)
- 📈 **Observability** - Metrics, logging, and tracing
- 🐳 **Docker Support** - Containerized deployment
- ☸️ **Kubernetes Ready** - Cloud-native deployment

## 🛠️ Technology Stack

- **Java** - Core programming language
- **Spring Boot** - Application framework
- **Spring Cloud** - Microservices toolkit
- **Redis** - Message broker and caching
- **Maven** - Build and dependency management
- **MapStruct** - Object mapping
- **Lombok** - Boilerplate reduction
- **Prometheus** - Metrics collection
- **Grafana** - Visualization and dashboards
- **Docker** - Containerization

## 🏗️ Architecture

### Service Architecture

```
┌─────────────────┐
│  Config Server  │ (Port 8085)
└────────┬────────┘
         │
    ┌────┴────┐
    │         │
┌───▼───┐ ┌──▼────┐
│Config │ │Config │
└───┬───┘ └───┬───┘
    │         │
┌───▼─────────▼───┐
│ Messaging Layer │ (Port 6379)
└────────┬────────┘
         │
    ┌────┴────┬─────────────┐
    │         │             │
┌───▼───┐ ┌──▼────┐ ┌──────▼───┐
│Account│ │Payment│ │ Customer │
│(8081) │ │(8082) │ │  (8083)  │
└───────┘ └───────┘ └──────────┘
```

### Services

1. **Config Server** (Port 8085)
   - Centralized configuration management
   - Spring Cloud Config

2. **Messaging Layer** (Port 6379)
   - Redis-based message broker
   - Event-driven communication

3. **Account Service** (Port 8081)
   - Account management
   - Account operations

4. **Customer Service** (Port 8083)
   - Customer registration
   - Customer management

5. **Payment Service** (Port 8082)
   - Payment processing
   - Transaction management

## 🚀 Getting Started

### Prerequisites

- Java 8+
- Maven 3.x
- Docker (for containerized deployment)
- Redis (for messaging layer)

### Installation

1. **Clone the repository:**
```bash
git clone https://github.com/bhanuchaddha/Finance-System.git
cd Finance-System
```

2. **Build all services:**
```bash
mvn clean install
```

### Running Services

**Startup Sequence:**
1. Config Server
2. Messaging Layer (Redis)
3. Account Service
4. Customer Service
5. Payment Service

**Using Maven:**
```bash
# Terminal 1 - Config Server
cd config-server
mvn spring-boot:run

# Terminal 2 - Messaging Layer
cd messaging-layer
mvn spring-boot:run

# Terminal 3 - Account Service
cd accounts
mvn spring-boot:run

# Terminal 4 - Customer Service
cd customers
mvn spring-boot:run

# Terminal 5 - Payment Service
cd payments
mvn spring-boot:run
```

### Docker Deployment

**Build all Docker images:**
```bash
mvn clean install -Ddocker-build
```

**Run Docker containers:**
```bash
docker run -p 8085:8085 config-server
docker run -p 6379:6379 messaging-layer
docker run -p 8081:8081 accounts
docker run -p 8083:8083 customers
docker run -p 8082:8082 payments
```

## 📡 API Documentation

Complete API documentation available at:
**[Postman API Documentation](https://documenter.getpostman.com/view/3772012/SVSKKnyZ?version=latest)**

### Example Endpoints

**Customer Service:**
```http
POST /customers        # Register customer
GET  /customers/{id}   # Get customer details
```

**Account Service:**
```http
POST /accounts         # Open account
GET  /accounts/{id}    # Get account details
```

**Payment Service:**
```http
POST /payments         # Process payment
GET  /payments/{id}    # Get payment details
```

## 📊 Monitoring & Observability

### Prometheus & Grafana

The system includes comprehensive monitoring:
- **JVM Metrics** - Memory, CPU, threads
- **Application Metrics** - Request rates, response times
- **Custom Metrics** - Business-specific metrics

**Setup:**
1. Start Prometheus with `prometheus.yml`
2. Access Grafana at `http://localhost:3000`
3. Import dashboards from `wiki/` directory

**Monitoring Dashboard:**
![Monitoring Dashboard](wiki/images/jvm_micrometer_dashboard.png)

Detailed setup guide: [Application Monitoring](wiki/Application-Monitoring.md)

## 🏗️ Project Structure

```
Finance-System/
├── accounts/              # Account Service
├── customers/            # Customer Service
├── payments/             # Payment Service
├── messaging-layer/      # Redis Messaging
├── config-server/        # Configuration Server
├── api-testing/          # API Tests (Rest Assured)
├── wiki/                 # Documentation
└── pom.xml               # Parent POM
```

## 🔧 Configuration

### Spring Cloud Config

Centralized configuration in `config-server`:
- Database connections
- Service URLs
- Feature flags
- Environment-specific settings

### Application Properties

Each service has its own `application.properties`:
```properties
server.port=8081
spring.application.name=account-service
# Add service-specific configurations
```

## 🧪 Testing

**API Testing with Rest Assured:**
```bash
cd api-testing
mvn test
```

Tests include:
- Payment processing tests
- Traffic generation
- Integration tests

## 📚 Cloud-Native Features

- ✅ **Service Discovery** - Eureka integration
- ✅ **Load Balancing** - Spring Cloud LoadBalancer
- ✅ **Configuration Management** - Spring Cloud Config
- ✅ **Health Checks** - Spring Boot Actuator
- ✅ **Monitoring** - Prometheus metrics
- ✅ **Distributed Tracing** - Zipkin integration (planned)
- ✅ **Circuit Breaker** - Resilience patterns (planned)
- ✅ **API Gateway** - Edge service (planned)

## 🛣️ Roadmap

### Functional Roadmap
- [x] Customer Service
- [x] Account Service
- [x] Payment Service
- [x] Messaging Layer
- [ ] Loan Service
- [ ] Payment event caching and replay

### Technical Roadmap
- [ ] Rest input validations
- [ ] Enhanced logging
- [ ] Distributed tracing (Zipkin)
- [ ] Docker Compose setup
- [ ] Kubernetes deployment
- [ ] Authentication & JWT
- [ ] Cassandra integration
- [ ] Circuit breaker (Hystrix)
- [ ] Error handling framework
- [ ] Flyway migrations

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is open source and available for educational purposes.

## 🔗 Resources

- [Spring Cloud Documentation](https://spring.io/projects/spring-cloud)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Prometheus Documentation](https://prometheus.io/docs/)
- [Grafana Documentation](https://grafana.com/docs/)

## 🌟 Use Cases

- **Learning Microservices** - Complete microservices tutorial
- **Cloud-Native Development** - Modern architecture patterns
- **Spring Cloud** - Spring Cloud ecosystem reference
- **Distributed Systems** - Event-driven architecture
- **Observability** - Monitoring and metrics

---

**Built with Spring Boot & Spring Cloud ❤️**

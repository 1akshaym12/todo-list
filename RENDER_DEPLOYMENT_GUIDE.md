# Spring Boot Todo App - Render Deployment Guide

## Overview
This guide will help you deploy your Spring Boot Todo application to Render using Docker and PostgreSQL.

## Prerequisites
- ✅ GitHub repository with your Spring Boot code
- ✅ Render account (free tier available)
- ✅ Application configured for PostgreSQL

## Files Already Configured

### 1. Dockerfile
- Multi-stage build using Eclipse Temurin Java 21
- Optimized for production deployment
- Exposes port 8080

### 2. render.yaml
- Infrastructure as Code configuration
- Defines web service and PostgreSQL database
- Environment variables automatically configured

### 3. application-prod.properties
- Production-specific configuration
- PostgreSQL database settings
- Optimized connection pool settings
- Environment variable integration

### 4. pom.xml
- Updated with PostgreSQL driver
- Java 21 compatibility
- Spring Security included

## Deployment Steps

### Step 1: Push Latest Changes to GitHub
```bash
git add .
git commit -m "Configure for Render deployment"
git push origin main
```

### Step 2: Create Render Service

1. **Login to Render Dashboard**
   - Go to https://render.com
   - Sign in with your GitHub account

2. **Create New Service**
   - Click "New +" button
   - Select "Blueprint"
   - Connect your GitHub repository: `https://github.com/1akshaym12/todo-list`

3. **Configure Blueprint**
   - Render will automatically detect the `render.yaml` file
   - Review the configuration:
     - **Web Service**: `todo-app`
     - **Database**: `todo-app-db` (PostgreSQL)
     - **Plan**: Free tier

4. **Deploy**
   - Click "Apply" to start deployment
   - Render will:
     - Create PostgreSQL database
     - Build Docker image
     - Deploy web service
     - Configure environment variables automatically

### Step 3: Monitor Deployment

1. **Check Build Logs**
   - Monitor the build process in Render dashboard
   - Ensure Docker build completes successfully

2. **Verify Database Connection**
   - Check that environment variables are properly set
   - Verify PostgreSQL database is running

3. **Test Application**
   - Once deployed, access your app at the provided Render URL
   - Test API endpoints and functionality

## Environment Variables (Auto-configured)

The following environment variables are automatically set by Render:

- `JDBC_DATABASE_URL`: PostgreSQL connection string
- `JDBC_DATABASE_USERNAME`: Database username
- `JDBC_DATABASE_PASSWORD`: Database password
- `SPRING_PROFILES_ACTIVE`: Set to "prod"
- `PORT`: Application port (8080)

## API Endpoints

Your deployed application will have the following endpoints:

- `GET /api/tasks` - Get all tasks
- `POST /api/tasks` - Create new task
- `PUT /api/tasks/{id}` - Update task
- `DELETE /api/tasks/{id}` - Delete task
- Static files served from `/` (HTML, CSS, JS)

## Database Schema

The application uses Hibernate with `ddl-auto=update`, so tables will be created automatically:

- `task` table with fields: id, title, description, completed, created_date, etc.

## Troubleshooting

### Common Issues:

1. **Build Failures**
   - Check Java version compatibility (using Java 21)
   - Verify all dependencies in pom.xml

2. **Database Connection Issues**
   - Ensure PostgreSQL service is running
   - Check environment variables in Render dashboard

3. **Application Not Starting**
   - Review application logs in Render dashboard
   - Check for any missing configuration

### Logs Access:
- Go to your service in Render dashboard
- Click on "Logs" tab to view real-time logs
- Check both build logs and runtime logs

## Cost Information

**Free Tier Limits:**
- Web Service: 750 hours/month (enough for continuous running)
- PostgreSQL: 1GB storage, 1 month retention
- Automatic sleep after 15 minutes of inactivity

**Upgrading:**
- Paid plans available for production use
- No sleep mode on paid plans
- Increased database storage and retention

## Security Notes

- Database credentials are automatically managed by Render
- HTTPS is enabled by default
- Environment variables are encrypted
- Spring Security is configured for authentication

## Next Steps After Deployment

1. **Custom Domain** (Optional)
   - Add custom domain in Render dashboard
   - Configure DNS settings

2. **Monitoring**
   - Set up health checks
   - Configure alerts for downtime

3. **Scaling**
   - Upgrade to paid plan for auto-scaling
   - Configure horizontal scaling if needed

## Support

- Render Documentation: https://render.com/docs
- Spring Boot Documentation: https://spring.io/projects/spring-boot
- PostgreSQL Documentation: https://www.postgresql.org/docs/

---

Your Spring Boot Todo application is now ready for deployment on Render! 🚀

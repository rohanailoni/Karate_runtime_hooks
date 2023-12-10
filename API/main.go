package main

import (
	"net/http"

	"github.com/gin-gonic/gin"
)

func main() {
	router := gin.Default()

	router.GET("/health", func(c *gin.Context) {
		c.JSON(http.StatusOK, gin.H{"status": "OK"})
	})

	router.GET("/api/resource", func(c *gin.Context) {
		c.JSON(http.StatusOK, gin.H{"id": 123, "name": "Example Resource"})
	})

	router.POST("/api/resource", func(c *gin.Context) {
		c.JSON(http.StatusCreated, gin.H{"status": "Resource created successfully"})
	})

	router.Run(":8090")
}

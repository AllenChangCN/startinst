package resources

import (
	"github.com/gin-gonic/gin"
	log "github.com/sirupsen/logrus"
	//"fmt"
	//"../util"
)

type UserResource struct {
}

func (r *UserResource) FetchAllUsers(c *gin.Context) {
	log.Info("asdf")
	c.JSON(200, "H")
	return
}
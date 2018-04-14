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

	//id, idString := util.SnowflakeID()
	//fmt.Print(id)
	//fmt.Print(idString)
	log.Info("hhhh")
	c.JSON(200, "H")
	return
}
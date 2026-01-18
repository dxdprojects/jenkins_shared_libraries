def call(String credId, String imageName){
  withCredentials([usernamePassword(credentialsId: "${credId}", passwordVariable: "dockerPass", usernameVariable: "dockerUser")]){
                    sh "docker login -u ${env.dockerUser} -p ${env.dockerPass} "
                    sh "docker image tag ${imageName} ${env.dockerUser}/${imageName}"
                    sh "docker push ${env.dockerUser}/${imageName}"
                }
}

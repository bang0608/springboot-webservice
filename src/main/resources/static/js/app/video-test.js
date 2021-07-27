// var url = 'https://lite-storage.flipflop.tv/bbb.mp4';
var url = 'https://lite-storage.flipflop.tv/trunk-dev/apps/60ff9599e4a73414ca43c08c/videos/60ffa5229e444ab647396844/files/processed/processed_test.mp4';

// let player=videojs('my-video');
// videojs.Hls.xhr.beforeRequest = (options) => {
//   console.log(options);
//   options.headers = {
//     "Authorization": "Bearer helloworld"
//   }
//   return options;
// };

// console.log('1')
// play();
init();
console.log('2')


async function init() {
  const videoSource = document.getElementById("my-video");

  const result = await fetch(url, {
    method: 'get',
    // headers: {
    //   "Authorization": "Bearer helloworld",
    //   "Access-Control-Allow-Origin": "*"
    // }
  });

  const blob = await result.blob();

  if (blob) {
    videoSource.src = URL.createObjectURL(blob);
    // Load the new resource
    videoSource.parentElement.load();

    console.info("Ready!", videoSource.src);
  } else {
    console.warn("Can not load");
  }




//  const reader = result.body.getReader();
//    const stream = new ReadableStream({
//      start(controller) {
//        return pump();
//        function pump() {
//          return reader.read().then(({ done, value }) => {
//            // When no more data needs to be consumed, close the stream
//            if (done) {
//              controller.close();
//              return;
//            }
//            // Enqueue the next data chunk into our target stream
//            controller.enqueue(value);
//            return pump();
//          });
//        }
//      }
//    });
//    const blob = await new Response(stream).blob();
//
//    if (blob) {
//      videoSource.src = URL.createObjectURL(blob);
//      // Load the new resource
//      videoSource.parentElement.load();
//      console.info("Ready!", videoSource.src);
//    } else {
//      console.warn("Can not load");
//    }
}

async function play(){
  await new Promise(resolve => setTimeout(resolve, 2000));
  player.src({
    src: url,
    type: 'video/mp4',
  });
  player.play();
}